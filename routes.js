// routes.js
const express = require('express');
const router = express.Router();
const mysql = require('mysql');

// Configuração da conexão com o banco de dados
const connection = mysql.createConnection({
    host: 'localhost',
    user: 'matheusfurtado',
    password: 'projeto#123',
    database: 'locadora_filmes',
});


// Conectar ao banco de dados
connection.connect();

// Rota para obter todos os filmes
router.get('/filmes', (req, res) => {
  // Lógica para obter todos os filmes do banco de dados
  connection.query('SELECT * FROM filmes', (error, results) => {
    if (error) {
      console.error('Erro ao obter filmes:', error);
      res.status(500).json({ error: 'Erro interno do servidor' });
    } else {
      res.json(results);
    }
  });
});

// Rota para obter detalhes de um filme pelo ID
router.get('/filmes/:id', (req, res) => {
  const filmeId = req.params.id;
  // Lógica para obter detalhes do filme pelo ID do banco de dados
  connection.query('SELECT * FROM filmes WHERE id = ?', [filmeId], (error, results) => {
    if (error) {
      console.error('Erro ao obter detalhes do filme:', error);
      res.status(500).json({ error: 'Erro interno do servidor' });
    } else {
      res.json(results[0]); // A resposta é um array, pegamos o primeiro elemento
    }
  });
});

// Rota para obter todos os clientes
router.get('/clientes', (req, res) => {
  // Lógica para obter todos os clientes do banco de dados
  connection.query('SELECT * FROM clientes', (error, results) => {
    if (error) {
      console.error('Erro ao obter clientes:', error);
      res.status(500).json({ error: 'Erro interno do servidor' });
    } else {
      res.json(results);
    }
  });
});

// Fechar a conexão quando o servidor for encerrado
process.on('SIGINT', () => {
  connection.end();
  process.exit();
});

module.exports = router;
