package com.geko.importexcel.Service;

import org.springframework.web.multipart.MultipartFile;

public interface ImportarExcel {

    Boolean Importar(MultipartFile file);

    Boolean SaveFile(MultipartFile file);
}
