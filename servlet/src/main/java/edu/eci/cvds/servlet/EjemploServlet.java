package edu.eci.cvds.servlet;

import java.io.*;

import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.eci.cvds.servlet.model.Todo;
import java.util.ArrayList;
import java.net.MalformedURLException;

@WebServlet(
    urlPatterns = "/EjemploServlet"
)
public class EjemploServlet extends HttpServlet{
    static final long serialVersionUID = 34L;

    @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Writer responseWriter = resp.getWriter();
       String respuesta = "<Title>BAD REQUEST</Title>";
       try{
           Optional<Integer> optName = Optional.ofNullable(Integer.parseInt(req.getParameter("id")));
           int id = 0;

           if(optName.isPresent()){
               id = optName.get();
               ArrayList<Todo> lista = new ArrayList<Todo>();
               lista.add(Service.getTodo(id));
	   	
	       resp.setStatus(HttpServletResponse.SC_OK);
               responseWriter.write(Service.todosToHTMLTable(lista));
           } 
       } catch(FileNotFoundException e){
           resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
	   //resp.setStatus(404);
       } catch(NumberFormatException e){
	   resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
           responseWriter.write(respuesta);
       } catch(MalformedURLException e){
           resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
       } catch(Exception e){
	   
	   resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
       } 
       responseWriter.flush();
   }
}
