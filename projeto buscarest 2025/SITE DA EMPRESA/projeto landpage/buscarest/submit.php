<?php
$servername = "sql212.infinityfree.com";
$username = "if0_38721294";
$password = "tricolo14"; 
$database = "if0_38721294_epiz_12345678_buscarest";
$port = 3306;

$conn = new mysqli($servername, $username, $password, $database, $port);

if ($conn->connect_error) {
    die("❌ Falha na conexão: " . $conn->connect_error);
}

$name = $_POST['name'];
$email = $_POST['email'];
$restaurant = $_POST['restaurant'];
$date = $_POST['date'];
$time = $_POST['time'];
$guests = $_POST['guests'];

$sql = "INSERT INTO reservas (name, email, restaurant, date, time, guests)
        VALUES ('$name', '$email', '$restaurant', '$date', '$time', '$guests')";

if ($conn->query($sql) === TRUE) {
    echo "✅ Reserva feita com sucesso!";
} else {
    echo "❌ Erro ao inserir: " . $conn->error;
}

$conn->close();
?>
