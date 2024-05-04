<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.File" import="java.io.FileInputStream" 
    import="java.io.InputStream" import="java.io.OutputStream"
    import="utils.JSFunction" import="java.io.FileNotFoundException"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
String saveDirectory = application.getRealPath("/Uploads");
String saveFileName = request.getParameter("sName");
String originalFilename = request.getParameter("oName");

try{
	File file = new File(saveDirectory, saveFileName);
	InputStream inStream = new FileInputStream(file);
	String client = request.getHeader("User-Agent");
	/* 
	if(client.indexOf("WOW64")==-1){
		originalFilename = new String(originalFilename.getBytes("UTF-8"),
				"ISO-8859-1");
	} else {
		originalFilename = new String(originalFilename.getBytes("KSC5601"),
				"ISO-8859-1");
	} */
	response.reset();
	response.setContentType("application/octet-stream");
	response.setHeader("Content-Disposition", "attachment; filename=\"" + 
			originalFilename+"\"");
	response.setHeader("Content-Length",""+file.length());
	out.clear();
	OutputStream outStream = response.getOutputStream();
	
	byte b[] = new byte[(int)file.length()];
	int readBuffer = 0;
	while((readBuffer=inStream.read(b))>0){
		outStream.write(b,0,readBuffer);
	}
	inStream.close();
	outStream.close();
} catch (Exception e){
	e.printStackTrace();
}
%>