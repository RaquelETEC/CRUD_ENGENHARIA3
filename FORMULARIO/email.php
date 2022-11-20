<?php

if(isset($_POST['email']) && !empty($_POST['email']) ){

$nome = addslashes($_POST['nome'])
$email = addslashes($_POST['email'])
$messagem =  addslashes($_POST['menssagem'])


$to = "tccametec@gmail.com";
$subjet = "Contato - SiteAMETEC";
$body = "Nome: ".$nome. "\n".
        "Email": .$email."\n". 
        "messagem": .$messagem; 

$header = "from: raquelesilvele@gmail.com"."\r\n"
    ."Reply-To:".$email."\n"
    ."X=Mailer:PHP/".phpversion(); 

if(mail($to,$subjet,$body,$header)){
    ALERT('EMAIL ENVIADO COM SUCESSO');
}
else {
    Alert("ALGO DEU ERRADO, SEU EMAIL N FOI ENVIADO");
}


}
else{
    Alert('ALGO DEU ERRADO'); 
}
?>