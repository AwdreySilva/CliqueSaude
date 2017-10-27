<%-- 
    Document   : BuscarMedicos
    Created on : 09/05/2017, 14:50:25
    Author     : Jess
--%>

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
			
			
			        <table border='1' id = "tab">
            <tr>
                <td>
                    <table id = "tab2">
                                <tr>
                                    <td>
                                        <h1>Bucar Médico</h1><br>
                                      <form method ="POST" action="FrontControllerServlet">           
                                            <fieldset>
                                                    <legend>Buscar</legend>
                                                       <p>ID: <input type="text" name="id" size="40" maxlength="500"></p><br>

                                              </fieldset><br><br>

                                             <fieldset>
                                                   <legend>Ou</legend>

                                                      <p>Nome: <input type="text" name="nome" size="90" maxlength="500"></p><br>   

                                               </fieldset><br>

                                               <fieldset>
                                                   <legend>Ou</legend>

                                                      <p>Especialidade: <input type="text" name="especialidade" size="90" maxlength="500"></p><br>   

                                               </fieldset><br>
                                             <input type="hidden" name="control" value="BuscaMedico">
                                             <input type="submit" class="bt" value="Buscar"><br>
                                             <input type="reset" class="bt" value="Limpar"> <br>
                                     </form>
                                        
                                     <form method ="POST" action="FrontControllerServlet">           

                                         <input type="hidden" name="control" value="BuscaMedicosTodos"><br>
                                             <input type="submit" class="bt" value="Buscar Todos"><br>
                                            
                                     </form>
                                    </td>
                                  </tr>
                            </table>
                        
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