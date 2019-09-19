package edu.eci.cvds.servlet.model;

import java.io.IOException;
import java.io.Writer;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Todo{
    private int userId;
    private int id;
    private String title;
    private boolean completed;
    public Todo(){

    }
    
    public int getUserId(){
    	return userId;
    }

    public void setUserId(int userId){
	this.userId = userId;
    }




    public int getId(){
    	return id;
    }

    public void setId(int id){
	this.id = id;
    }




    public String getTitle(){
    	return title;
    }

    public void setTitle(String title){
	this.title = title;
    }


    public boolean getCompleted(){
    	return completed;
    }

    public void setCompleted(boolean completed){
	this.completed = completed;
    }



}
