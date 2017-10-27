<%-- 
    Document   : consulta
    Created on : 07/05/2017, 22:27:57
    Author     : Jess
--%>

<%@page import="consultorio.entidades.Cliente"%>
<%@page import="consultorio.dao.jpa.cliente.ClienteDAOFactory"%>
<%@page import="consultorio.dao.jpa.cliente.ClienteDAO"%>
<%@page import="java.util.Collection"%>
<%@page import="consultorio.dao.jpa.medico.MedicoDAOFactory"%>
<%@page import="consultorio.dao.jpa.medico.MedicoDAO"%>
<%@page import="consultorio.entidades.Medico"%>
<%@page import="java.util.List"%>
<% MedicoDAO medicoDAO = MedicoDAOFactory.getMedicoDAO();
   List medicoLista = medicoDAO.buscaTodosMedico();
   
   ClienteDAO clienteDAO = ClienteDAOFactory.getClienteDAO();
   List clienteLista = clienteDAO.buscaTodosClientes();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<title>Cadastro Médico 2.0</title>
<link href="style.css" type="text/css" rel="stylesheet"/>

</head>
<!-- <div id="bg-conteudo"></div> -->
	<div id="wrapper"> 
    	<header id="cabecalho">
        	<span class="logo"><a href="index.html"><img src="imagens/logo.png" width="332" height="120"/></span></a>
        	<nav class="menu">
            	<ul>
			<li><a href="index.html">&nbsp&nbspHome&nbsp&nbsp  |</li></a>
            <li><a href="medico.jsp">  Acesso Médico&nbsp&nbsp  |</li></a>
            <li><a href="consulta.jsp">  Consultas  &nbsp&nbsp|</li></a>
            <li><a href="agendaform.jsp">  Agenda &nbsp&nbsp |</li></a>
            <li><a href="cliente.jsp">  Paciente&nbsp&nbsp&nbsp&nbsp</li></a>

    	</ul>
    </nav>
 </div>
	        </header>

<!-- PARTE SUPERIOR termina aqui -->

<body>

	<div id="wrapper">
	        <div id="conteudo">
			<article id = "frente" >
        <table border='1' id = "tab">
            <tr>
                <td>
                    <form method ="POST" action="FrontControllerServlet">
                        <table id = "tab2">
                                <tr>
                                    <td>
                                        <h1>Cadastrar Consulta</h1><br>
                                        
                                        <fieldset>
                                                Data da Consulta:       
                                                <input type="date" name="date">
                                                
                                                Horario:
                                                <input type="time" name="time"></p><br>
                                                
                                        <fieldset>
                                            <legend>Médico</legend>
                    <%--  MEDICO -------------------------------------------------------------------------------%> 
                                            <select name="idMed">
                                                <% for( Object obj : medicoLista){ %>
                                                    <% Medico medico = (Medico) obj; %>
                                                    <option value="<%=medico.getId()%>">
                                                        <%=medico.getNome()%>
                                                    </option>
                                                <% } %>
                                            </select>
                        
                                       </fieldset><br><br>
                                       
                                            <fieldset>
                                            <legend>Paciente</legend>
                    <%--  CLIENTE -------------------------------------------------------------------------------%>
                                            <select name="idCli">
                                                <% for( Object obj : clienteLista){ %>
                                                    <% Cliente cliente = (Cliente) obj; %>
                                                    <option value="<%=cliente.getId()%>">
                                                        <%=cliente.getNome()%>
                                                    </option>
                                                <% } %>
                                            </select>
                                        </fieldset>
                                        </fieldset><br>
                                      <input type="hidden" name="control" value="AddConsulta">
                                     <input type="submit" class="bt" value="Salvar">
                                     <input type="reset" class="bt" value="Limpar"> 
                                    </td>
                                  </tr>
                            </table>
                     </form>
                        
                </td>
              </tr>
        </table>
    </article>
         
                        
              

		<!-- FOOTER começa aqui -->		
		<br><br><br><br>
<footer id="rodape">
    <div id="copyright">
    	<span class="texto-copyright"><br>Desenvolvido por Fellipe Fingoli, Jessica Silveira e Joyce Miyazato. 
        								<br>© Todos os direitos reservados.</span>     
	</div>  
</footer>

	
        </div>  

</div>	
	
</body>
</html>
<!-- FOOTER termina aqui -->


<style>
            .bt{
                width: 1000px;
                height: 40px;
                cursor: pointer;
            }
          input:hover, select:hover, textarea:hover{border:2px solid blueviolet}
</style>		  