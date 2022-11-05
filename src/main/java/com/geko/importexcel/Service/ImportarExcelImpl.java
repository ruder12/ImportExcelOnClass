package com.geko.importexcel.Service;

import com.geko.importexcel.Dao.ImportExcelDao;
import com.geko.importexcel.Model.Producto;
import com.poiji.bind.Poiji;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transaction;
import javax.transaction.Transactional;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
public class ImportarExcelImpl implements  ImportarExcel{

    @Autowired
    private ImportExcelDao getDao;

    String pactFile = ".//src//main//resources//files//";

    @Override
    @Transactional
    public Boolean Importar(MultipartFile file) {
        File fil = new File(pactFile + file.getOriginalFilename());
        List<Producto> lista = Poiji.fromExcel(fil,Producto.class);
        if(lista != null){
            for (Producto pro : lista){
                pro.setFecha_Registro(new Date());
                pro.setSede(1L);
                getDao.save(pro);
            }

            return true;
        }
        return null;
    }

    @Override
    public Boolean SaveFile(MultipartFile file) {

        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(pactFile + file.getOriginalFilename());
                Files.write(path,bytes);
                return true;
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }
}
