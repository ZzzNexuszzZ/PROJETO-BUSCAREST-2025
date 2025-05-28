<?php
$servername = "sql212.infinityfree.com";
$username = "if0_38721294";
$password = "tricolo14";
$database = "if0_38721294_epiz_12345678_buscarest";
$port = 3306;

// Conexão com o banco de dados
$conn = new mysqli($servername, $username, $password, $database, $port);
if ($conn->connect_error) {
    die("Erro na conexão: " . $conn->connect_error);
}

$sql = "SELECT * FROM reservas ORDER BY date, time";
$result = $conn->query($sql);
?>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Reservas Agendadas</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 40px;
            background-color: #f5f5f5;
        }
        h2 {
            text-align: center;
        }
        table {
            border-collapse: collapse;
            width: 100%;
            background-color: #fff;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #0080ff;
            color: white;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
    </style>
</head>
<body>
    <h2>Reservas Agendadas</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>E-mail</th>
            <th>Restaurante</th>
            <th>Data</th>
            <th>Hora</th>
            <th>Nº Pessoas</th>
        </tr>
        <?php if ($result->num_rows > 0): ?>
            <?php while($row = $result->fetch_assoc()): ?>
                <tr>
                    <td><?= htmlspecialchars($row['id']) ?></td>
                    <td><?= htmlspecialchars($row['name']) ?></td>
                    <td><?= htmlspecialchars($row['email']) ?></td>
                    <td><?= htmlspecialchars($row['restaurant']) ?></td>
                    <td><?= htmlspecialchars($row['date']) ?></td>
                    <td><?= htmlspecialchars($row['time']) ?></td>
                    <td><?= htmlspecialchars($row['guests']) ?></td>
                </tr>
            <?php endwhile; ?>
        <?php else: ?>
            <tr><td colspan="7">Nenhuma reserva encontrada.</td></tr>
        <?php endif; ?>
    </table>
</body>
</html>

<?php $conn->close(); ?>
