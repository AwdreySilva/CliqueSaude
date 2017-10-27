<%-- 
    Document   : ResultadoMedico
    Created on : 09/05/2017, 15:02:39
    Author     : Jess
--%>

<%@page import="consultorio.entidades.Telefone"%>
<%@page import="consultorio.entidades.Endereco"%>
<%@page import="consultorio.entidades.Medico"%>
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
			
			
  
  <<% 
             Medico med = (Medico)request.getAttribute("medico");
             Endereco end = (Endereco)request.getAttribute("endereco");
             Telefone t = (Telefone)request.getAttribute("tel");
    %>
  
    <article id = "frente" >
        <table border='1' id = "tab">
            <tr>
                <td>
                    <form method ="POST" action="FrontControllerServlet">
                        <table id = "tab2">
                                <tr>
                                    <td>
                                        <h1>Busca Medico</h1>
                                            <table table border='1'>
                                                <tr >
                                                    <td class="td">
                                                        Nome
                                                    </td>
                                                
                                                    <td class="td">
                                                        Sexo
                                                    </td>
                                               
                                                    <td class="td">
                                                        Data Nascimento
                                                    </td>
                                             
                                                    <td class="td"> 
                                                        E-mail
                                                    </td>
                                                    <td class="td"> 
                                                        CRN
                                                    </td
                                                    <td class="td"> 
                                                        Especialidade
                                                    </td>
                                                    <td class="td"> 
                                                        Endereco
                                                    </td>
                                                    <td class="td"> 
                                                        Telefone
                                                    </td>
                                                     <td class="td"> 
                                                        Endereco
                                                    </td>
                                                </tr>
                                                 <tr >
                                                    <td class="tr">
                                                        <%=med.getNome()%>
                                                    </td>
                                                    <td class="tr">
                                                        <%=med.getSexo()%>
                                                    </td>
                                                    <td class="tr">
                                                        <%=med.getDataNascimento()%>
                                                    </td>
                                                    <td class="tr">
                                                        <%=med.getEmail()%>
                                                    </td>
                                                    <td class="tr">
                                                        <%=med.getCrm()%> 
                                                    </td>
                                                    <td class="tr">
                                                        <%=med.getEspecialidade()%> 
                                                    </td>
                                                    <td class="tr">
                                                        <%=t.toString()%>
                                                    </td>
                                                     <td class="tr">
                                                        <%=end.toString()%> 
                                                    </td>
                                                </tr>
                                            </table><br>   
                                                                                              
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