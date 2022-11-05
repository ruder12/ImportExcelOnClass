package com.geko.importexcel.Controller;

import com.geko.importexcel.Service.ImportarExcelImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class ImportarExcelController {

    @Autowired
    private ImportarExcelImpl serviceExcel;

    public String index(){
        return "index";
    }

    @PostMapping("/cargarExcel")
    public String cargarExcel(@RequestParam("file") MultipartFile file){
      System.out.println("solictud post");
        if(serviceExcel.SaveFile(file)){
            serviceExcel.Importar(file);
        }
        return "redirect:/";
    }
}
