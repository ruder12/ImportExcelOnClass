package com.geko.importexcel.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelRow;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name ="producto")
@Data
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ExcelRow
	private Long prod_id;
	
	@Column(name = "prod_Codigo",nullable = false)
	@ExcelCellName("codigo")
	private String Codigo;
	
	@Column(name = "prod_Nombre",nullable = false)
	@ExcelCellName("Nombre")
	private String Nombre;
	
	@Column(name = "prod_Marca")
	@ExcelCellName("Marca")
	private String Marca;
	
	@Column(name = "prod_Modelo")
	@ExcelCellName("Modelo")
	private String Modelo;
	
	@Column(name = "prod_Serie")
	@ExcelCellName("Serie")
	private String Serie;
	
	@Column(name = "prod_Precio")
	@ExcelCellName("Precio")
	private Double Precio;
	
	@Column(name = "prod_Status")
	@ExcelCellName("Estado")
	private int estado;
	
	@Column(name = "prod_fecha_registro")
	@Temporal(TemporalType.DATE)
	@CreatedDate
	private Date Fecha_Registro;
	
	@Column(name = "prod_Descripcion")
	@ExcelCellName("Descripcion")
	private String Descripcion;
	
	@Column(name = "prod_mantenimiento",nullable = true)
	@ExcelCellName("Mantenimiento")
	private String FechaMantenimiento;
	
	@Column(name = "prod_tipo",nullable = true,columnDefinition = "integer default '0'")
	@ExcelCellName("Tipo")
	private int tipo;

	@Column(name = "prod_Categoria_Id")
	@ExcelCellName("Categoria")
	private Long Categoria;
	
	@Column(name="prod_sede_id" ,nullable = true)
	private Long sede;

}
