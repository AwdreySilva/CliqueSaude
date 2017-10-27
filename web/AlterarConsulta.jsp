<%-- 
    Document   : AlterarConsulta
    Created on : 07/05/2017, 13:58:17
    Author     : Jess
--%>

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
                    <form method ="POST" action="FrontControllerServlet">
                        <table id = "tab2">
                                <tr>
                                    <td>
                                       <h1>Alterar Consuta</h1>
                                        
                                        
                                        <fieldset>
                                                
                                               <p>ID: <input type="text" name="id" size="40" maxlength="500"></p><br>
                                                Data da Consulta:       
                                                <input type="date" name="date">
                                                
                                                Horario:
                                                <input type="time" name="time"></p><br>
                                                
                                                <p>Busca: <select name ="Busca"> 
                                                        <option value="segunda"> Segunda- feira </option>
                                                        <option value="terca"> Terça- feira </option>
                                                        <option value="quarta"> Quarta- feira </option>
                                                        <option value="quinta"> Quinta- feira </option>
                                                        <option value="sexta"> Sexta- feira </option>
                                                    </select></p><br>
                                                
                                        <fieldset>
                                             <legend>Médico ( Busca Por Nome ou ID ou Especialidade)</legend>
                    <%--  MEDICO -------------------------------------------------------------------------------%> 
                                            <p>ID Médico: <input type="text" name="idMed" size="40" maxlength="500"></p><br>
                                            <p>Nome Médico: <input type="text" name="nomeMed" size="90" maxlength="500"></p><br>
                                            <p>Esspecialidade: <input type="text" name="especialidade" size="90" maxlength="500"></p><br>
                        
                                       </fieldset><br><br>
                                       
                                            <fieldset>
                                            <legend>Paciente (Busca Por Nome ou ID )</legend>
                    <%--  CLIENTE -------------------------------------------------------------------------------%>                            
                                                <p>ID Paciente: <input type="text" name="idCli" size="40" maxlength="500"></p><br>
                                                
                                               <p>Nome Paciente: <input type="text" name="nomeCli" size="90" maxlength="500"></p><br>   
                                        </fieldset>
                                        </fieldset><br>
                                     
                                      <input type="hidden" name="control" value="AlterarConsulta">
                                     <input type="submit" class="bt" value="Alterar">
                                     <input type="reset" class="bt" value="Limpar"> 
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