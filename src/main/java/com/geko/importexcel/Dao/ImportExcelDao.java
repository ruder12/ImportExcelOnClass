package com.geko.importexcel.Dao;

import com.geko.importexcel.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImportExcelDao extends JpaRepository<Producto,Long> {

}
