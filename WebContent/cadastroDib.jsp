<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Cadastro</title>
    <script src="js\jquery.js"></script>
    <script src="js\jquery.validate.min.js"></script>
    <script src="js\additional-methods.min.js"></script>
    <script src="js\localization\messages_pt_PT.js"></script>
    <link rel="icon" href="Imagens/icon.png">
    <link rel="stylesheet" href="css/cadastro.css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <script src="bootstrap/js/bootstrap.min.js"></script>
<!--     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->
    <script src="https://kit.fontawesome.com/c34d53500c.js" crossorigin="anonymous"></script>
    
    <script type="text/javascript"> 
      jQuery.validator.addMethod("telefone", function (value, element) {
        value = value.replace("(", "");
        value = value.replace(")", "");
      value = value.replace("-", "");
      return this.optional(element) || /[0-9]{10}/.test(value);
      
    }, "Por favor, um telefone válido");
    
    jQuery.validator.addMethod("sonumeros", function (value, element) {
      return this.optional(element) || /[0-9]{5}/.test(value);
  
    }, "O rm só pode conter numeros  ");
    
    $.validator.addMethod( "semespaço", function( value, element ) {
      return this.optional( element ) || /^\S+$/i.test( value );
    }, "Rm não deve conter espaços" );   
    
    
    $(document).ready(function(){
      $("#formcadastro").validate({
        rules:{
          nome: {
                required: true,
                maxlength:50,
                minlength:6,
                minWords: 2,
                required: true
              },
              email:{
                required: true,
                email: true
              },
              confirmesenha:{
                equalTo:senha,
                required: true
                
              },
              cpf:{
                cpfBR:11,
                required: true,
                sonumeros:true
              },
              telefone:{
                telefone:true,
                sonumeros:true
              },
              
              cep:{
                postalcodeBR: true,
                required: true,
                sonumeros:true
              },
              rm:{
                maxlength:5,
                minlength:5,
                required: true,
                semespaço:true,
                sonumeros:true
                
              },
              
              
              submitHandler: function(form){
                alert("Cadastrado")
              }
            }
          })
        })
         
  </head>
    <body>

      <div class="container edit">
        <h2>Cadastro</h2>
        <div class="row">
          <div class="col-3"></div>
          <div class="col-md-6 col-sm-6 col-xs-12 marcador">
            <form class="form-container" action="UserServlet" method="post" id="formcadastro">
            <input type="hidden" name="action" value="Cadastrar">
              <div class="form-group">
                <label for="rm">RM</label><br>
                <input type="text" name="rm" placeholder="RM" id="rm">
              </div>
              <div class="form-group">
                <label for="nome">Nome</label><br>
                <input type="text" name="nome" placeholder="Nome Completo" id="nome">
              </div>
              <div class="form-group">
                <label for="senha">Email</label><br>
                <input type="password" name="email" placeholder="Senha" id="">
              </div>
              <div class="form-group">
                <label for="senha">Telefone</label><br>
                <input type="text" name="telefone" placeholder="Confirmar senha" id="telefone">
              </div>
              <div class="form-group">
                  <label for="email">CPF</label><br>
                  <input type="email" name="cpf" placeholder="E-mail"  id="cpf">
              </div>
              <div class="form-group">
                  <label for="nome">CEP</label><br>
                  <input type="text" name="cep" placeholder="Telefone" id="cep">
              </div>
              <div class="form-group">
                  <label for="nome">Senha</label><br>
                  <input type="text" name="senha" placeholder="CPF" id="senha">
              </div>
              <div class="form-group">
                  <label for="nome">Confirmar senha</label><br>
                  <input type="text" name="confirmesenha" placeholder="Endereço" id="confirmesenha">
              </div>
              <input type="submit" value="Cadastrar" class="btn btn-block" name="button">
<!--               <button type="submit" name="button" class="btn btn-block"><a href="index.html">Cadastrar</a></button> -->

            </form>
          </div>
        </div>
      </div>
  </body>

  </html>


</html>
