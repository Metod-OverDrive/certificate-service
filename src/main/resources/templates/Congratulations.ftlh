<#ftl encoding="UTF-8">
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Congratulations</title>
    <style>
        #body {
            display: flex;
            font-family: "Segoe UI", serif;
            align-items: center;
            background-color: #607FF2;
            font-size: 30px;
            height: 150%;
        }

        #div {
            display: block;
            margin: 60px;
            font-family: "Segoe UI", serif;
            background-color: white;
            padding: 40px;
            border-radius: 20px;
            color: black;
        }

    </style>
</head>
<body>
<div id="body">
    <div id="div">
        <h1 style="text-align: center">Congratulations</h1>
        <p>Привет, ${name}!</p>
        <p>Спасибо что создали сертефикат с помощью этого маленького PDF сервиса.</p>
        <p>Приложение было сделано в качестве пробы пера для другого проекта,
            по этой причине я не стал усложнять сервис возможностью хранения HTTP в базе данных</p>
        <p>Спасибо за прочтение) <br> Metod-OverDrive</p>
    </div>
</div>
</body>
</html>