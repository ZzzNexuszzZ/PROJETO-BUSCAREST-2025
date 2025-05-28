<?php
$host = 'sql212.infinityfree.com';
$user = 'if0_38721294';
$password = 'tricolo14';
$database = 'if0_38721294_epiz_12345678_buscarest'; 
$port = 3306;

// Criação da conexão
$conn = new mysqli($host, $user, $password, $database, $port);

// Verificando a conexão
if ($conn->connect_error) {
    die("Conexão falhou: " . $conn->connect_error);
}
?>
