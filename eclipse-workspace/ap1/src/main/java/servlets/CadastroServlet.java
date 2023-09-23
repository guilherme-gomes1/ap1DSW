package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Carro;

@WebServlet(urlPatterns = "/carroServlet")
public class CadastroServlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Carro carro = new Carro();

		carro.setModelo(req.getParameter("modelo"));
		carro.setMarca(req.getParameter("marca"));
		carro.setAnoDeFabricacao(Integer.parseInt(req.getParameter("anoFabricacao")));
		
		
		PrintWriter writer = resp.getWriter();
		writer.write("<html>");
		writer.write("<head><title>Sucesso</title>");
		writer.write("<link rel=\"stylesheet\" href=\"styles.css\">");
		writer.write("<meta charset=\"ISO-8859-1\"></head>");
		writer.write("<body>");
		writer.write("<h1>Carro cadastrado com sucesso</h1>");
		writer.write("<ul>");
		writer.write("<li>");
		writer.write("<label class=\"labelStyle\">Modelo: " + carro.getModelo() + "</label></br>");
		writer.write("</li>");
		writer.write("<li>");
		writer.write("<label class=\"labelStyle\">Marca: " + carro.getMarca() + "</label></br>");
		writer.write("</li>");
		writer.write("<li>");
		writer.write("<label class=\"labelStyle\">Ano de Fabricação: " + carro.getAnoDeFabricacao() + "</label></br>");
		writer.write("</li>");
		writer.write("</ul>");
		writer.write("<a href=\"index.html\">voltar</a>");
		writer.write("</body>");
		writer.write("</html>");
	}
}
