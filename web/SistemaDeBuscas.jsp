<%-- 
    Document   : BuscarConsulta
    Created on : 07/05/2017, 14:03:02
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
			
			
  
 <article id = "frente" >
        <table border='1' id = "tab">
            <tr>
                <td>
                   
                        <table id = "tab2">
                                <tr>
                                    <td>
                                        <h1>Sistemas de Buscas</h1>    

                                        <form method ="POST" action="BuscarConsultas.jsp">
                                           <input type="submit" class="bt" value="Buscar Consulta">  
                                        </form>  <br><br>
                                           
                                         
                                         <form method ="POST" action="BuscarMedicos.jsp">
                                             <input type="submit" class="bt" value="Buscar Médico">  
                                        </form> <br><br>  
                                        
                                        <form method ="POST" action="BuscarClientes.jsp">
                                             <input type="submit" class="bt" value="Buscar Paciente">  
                                        </form> <br><br>  
                                    </td>
                                  </tr>
                            </table>                 
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