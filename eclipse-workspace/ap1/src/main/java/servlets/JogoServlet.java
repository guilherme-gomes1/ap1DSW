package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/jogoServlet")
public class JogoServlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer number1 = Integer.parseInt(req.getParameter("number1"));
		Integer number2 = Integer.parseInt(req.getParameter("number2"));
		Integer number3 = Integer.parseInt(req.getParameter("number3"));
		Integer number4 = Integer.parseInt(req.getParameter("number4"));
		Integer number5 = Integer.parseInt(req.getParameter("number5"));
		
		int numbers[] = {number1, number2, number3, number4, number5};
		ArrayList<Integer> pairs = new ArrayList<>();
		ArrayList<Integer> unpaireds = new ArrayList<>();
		
		PrintWriter writer = resp.getWriter();
		writer.write("<html>");
		writer.write("<head><title>Sucesso</title>");
		writer.write("<link rel=\"stylesheet\" href=\"styles.css\">");
		writer.write("<meta charset=\"ISO-8859-1\"></head>");
		writer.write("<body>");
		
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] %2 == 0) {
				pairs.add(numbers[i]);
			} else {
				unpaireds.add(numbers[i]);
			}
			
		}

		writer.write("<h2>Pares</h2>");
		writer.write("<ul>");
		pairs.forEach((num) -> {
			writer.write("<li>");
			writer.write("<label class=\"labelStyle\"> " + num + "</label>");
			writer.write("</li>");
		});
		writer.write("</ul>");
		
		writer.write("<h2>Ímpares</h2>");
		writer.write("<ul>");
		unpaireds.forEach((num) -> {
			writer.write("<li>");
			writer.write("<label class=\"labelStyle\"> " + num + "</label>");
			writer.write("</li>");
		});
		writer.write("</ul>");
		
		writer.write("<a href=\"index.html\">voltar</a>");
		writer.write("</body>");
		writer.write("</html>");
	}
}
