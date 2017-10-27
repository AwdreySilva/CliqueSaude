<%-- 
    Document   : ListarConsulta
    Created on : 09/05/2017, 13:10:28
    Author     : Jess
--%>

<%@page import="java.util.List"%>
<%@page import="consultorio.entidades.Consulta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
author Jessica Silveira/ Joyce Miyazato/ Felipe Figoli@
-->
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
			
			
			        <table border='1' id = "tab">
            <tr>
                <td>
                    <<% 
             List<Consulta> con = ( List<Consulta>)request.getAttribute("consulta");
            
    %>
  
  <table border='1' id = "tab">
            <tr>
                <td>
                    <form method ="POST" action="FrontControllerServlet">
                        <table id = "tab2">
                                <tr>
                                    <td>
                                        <h1>Agenda</h1>
                                        <a href ="AlterarConsulta.jsp">Alterar</a>
                                        <a href ="BuscarConsulta.jsp">Buscar</a><br><br>
                                            <table table border='1'>
                                                <tr >
                                                    <td class="td">
                                                        Data
                                                    </td>
                                                
                                                    <td class="td">
                                                        Horário
                                                    </td>
                                               
                                                    <td class="td">
                                                        Médico
                                                    </td>
                                             
                                                    <td class="td"> 
                                                        Paciente
                                                    </td>
                                                </tr
                                                <% for(Consulta c: con){ %>
                                                 <tr >   
                                                    <td class="tr">
                                                        <%=c.getData()%>
                                                    </td>
                                                    <td class="tr">
                                                        <%=c.getHorario()%>
                                                    </td>
                                                    <td class="tr">
                                                        <%=c.getMed()%>
                                                    </td>
                                                    <td class="tr">
                                                        <%=c.getCliente()%> 
                                                    </td>                   
                                                </tr>
                                            </table><br> 
                                            <%}%>
                                                                                              
                                    </td>
                                  </tr>
                            </table>
                     </form>
                        
                </td>
              </tr>
        </table>
                        
              

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