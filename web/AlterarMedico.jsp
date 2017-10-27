<%-- 
    Document   : AlterarMedico
    Created on : 07/05/2017, 14:02:13
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
                                        <h1>Alterar Médico</h1><br><br>
                                            <fieldset>
                                                <legend>Dados Pessoais</legend>
                                                <p>ID: <input type="text" name="id" size="40" maxlength="500"></p><br>
                                                <p>Nome: <input type="text" name="nome" size="90" maxlength="500"></p><br>
                                                <p>CRN: <input type="text" name="crn" size="30">
                                                Data de Nascimento:
                                                <input type="date", name="date"></p><br>
                                                Sexo:<br>
                                                <p><input type="radio" name="sex" value="masculino">Masculino 
                                                <input type="radio" name="sex" value="femnino">Feminino </p><br>                                         
                                                <p>E-mail: <input type="text" name="email" size="90" maxlength="500"></p><br>
                                                <p>Especialidade: <input type="text" name="especialidade" size="80" maxlength="500"></p><br>
                                               <fieldset>
                                                   <legend>Contato</legend>
                                                   <p>DDD: <input type="text" name="ddd1" maxlength="10">
                                                    Telefone: <input type="text" name="tel" maxlength="20">
                                                    DDD: <input type="text" name="ddd2" maxlength="10">
                                                    Celular: <input type="text" name="cel" maxlength="20"></p><br>
                                                </fieldset>
                                            </fieldset><br><br>
             
                                            <fieldset>
                                                <legend>Endereço</legend>
                                                <p>Rua: <input type="text" name="rua" size="70" maxlength="500">
                                                Número: <input type="text" name="numero" size="30" maxlength="500"></p><br>
                                                <p>Bairro: <input type="text" name="bairro" size="70" maxlength="500">
                                                CEP: <input type="text" name="cep" size="30" maxlength="500"></p><br>
                                                <p>Cidade: <input type="text" name="cidade">
                                                UF: <select name ="UF"> 
                                                        <option value="AC"> AC</option>      
                                                        <option value="AL"> AL</option> 
                                                        <option value="AM">AM</option> 
                                                        <option value="AP">AP</option> 
                                                        <option value="BA">BA</option> 
                                                        <option value="CE">CE</option> 
                                                        <option value="DF">DF</option> 
                                                        <option value="ES">ES</option> 
                                                        <option value="GO">GO</option> 
                                                        <option value="MA">MA</option> 
                                                        <option value="MG">MG</option> 
                                                        <option value="MS">MS</option> 
                                                        <option value="MT">MT</option> 
                                                        <option value="PA">PA</option> 
                                                        <option value="PB">PB</option> 
                                                        <option value="PE">PE</option> 
                                                        <option value="PI">PI</option> 
                                                        <option value="PR">PR</option> 
                                                        <option value="RJ">RJ</option> 
                                                        <option value="RN">RN</option> 
                                                        <option value="RO">RO</option> 
                                                        <option value="RR">RR</option> 
                                                        <option value="RS">RS</option> 
                                                        <option value="SC">SC</option> 
                                                        <option value="SE">SE</option> 
                                                        <option value="SP">SP</option> 
                                                        <option value="TO">TO</option> 
                                               </select></p><br>
                                               <p>País: <input type="text" name="pais" size="50" maxlength="500"></p><br>                                     
                                            </fieldset><br><br>
                                        
                                         <input type="hidden" value="AlterarMedico" name="control">
                                         <input type="submit" class="bt" value="Alterar"> <br> 
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