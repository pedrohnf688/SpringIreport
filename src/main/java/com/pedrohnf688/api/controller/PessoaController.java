package com.pedrohnf688.api.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;

@Controller
@RequestMapping("/relatorio")
public class PessoaController {

	@Autowired
	private DataSource dataSource;

	@GetMapping(value = "/pdf/{id}")
	public void gerarPdf(@PathVariable("id") Integer id, HttpServletResponse response)
			throws JRException, SQLException, IOException {

		Map<String, Object> parametros = new HashMap<>();

		parametros.put("Id_pessoa", id);

		// Pega o arquivo .jasper localizado em resources
		InputStream jasperStream = this.getClass().getResourceAsStream("/relatorios/reportProduto.jasper");

		// Cria o objeto JaperReport com o Stream do arquivo jasper
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		// Passa para o JasperPrint o relatório, os parâmetros e a fonte dos dados, no
		// caso uma conexão ao banco de dados
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, dataSource.getConnection());

		// Configura a respota para o tipo PDF
		response.setContentType("application/pdf");
		// Define que o arquivo pode ser visualizado no navegador e também nome final do
		// arquivo
		// para fazer download do relatório troque 'inline' por 'attachment'
		response.setHeader("Content-Disposition", "inline; filename=reportProduto.pdf");

		// Faz a exportação do relatório para o HttpServletResponse
		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}

	@GetMapping(value = "/excel/{id}")
	public void gerarExcel(@PathVariable("id") Integer id, HttpServletResponse response)
			throws JRException, SQLException, IOException {

		Map<String, Object> parametros = new HashMap<>();

		parametros.put("Id_pessoa", id);

		InputStream jasperStream = this.getClass().getResourceAsStream("/relatorios/reportProduto.jasper");

		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, dataSource.getConnection());

		response.setContentType("application/x-xls");
		response.setHeader("Content-Disposition", "inline; filename=reportProduto.xls");

		final OutputStream outStream = response.getOutputStream();

		JRXlsExporter exportsXLS = new JRXlsExporter();

//		exportsXLS.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//		exportsXLS.setParameter(JRExporterParameter.OUTPUT_STREAM, outStream);

		exportsXLS.setExporterInput(new SimpleExporterInput(jasperPrint));
		exportsXLS.setExporterOutput(new SimpleOutputStreamExporterOutput(outStream));

		SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();

		configuration.setOnePagePerSheet(true);
		configuration.setDetectCellType(true);
		configuration.setCollapseRowSpan(false);
		configuration.setWhitePageBackground(false);
		configuration.setRemoveEmptySpaceBetweenRows(false);

		exportsXLS.setConfiguration(configuration);

		exportsXLS.exportReport();

	}

}
