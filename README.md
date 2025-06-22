# 📦 Sistema de Cadastro de Pedidos

Projeto simples em Java para cadastro de clientes e gerenciamento de pedidos. Criado com foco em boas práticas de programação orientada a objetos (POO), usando apenas Java puro e estrutura de console.

---

## ✨ Funcionalidades

- Cadastro de clientes (com validação de CPF e e-mail duplicados)
- Criação de pedidos vinculados a clientes
- Listagem de todos os clientes cadastrados
- Listagem de todos os pedidos
- Filtro de pedidos por status (PENDENTE, PROCESSANDO, ENVIADO, ENTREGUE)
- Atualização do status de pedidos

---

## 🧠 Tecnologias e conceitos usados

- Java (sem frameworks)
- Programação orientada a objetos (POO)
- Enum para controle de status
- Listas dinâmicas com `ArrayList`
- Separação de responsabilidades (Model, Service e Main)
- Scanner para entrada de dados no console

---

## 📁 Estrutura do projeto

```bash
src/
├── com.cadastro/
│   └── Main.java
├── com.cadastro.model/
│   ├── Cliente.java
│   ├── Pedido.java
│   ├── Pessoa.java
│   └── StatusPedido.java
├── com.cadastro.service/
│   ├── ClienteService.java
│   └── PedidoService.java

```

## 🚀 Como executar

1) Clone o repositório:
```bash
https://github.com/leoferreira9/analise-vendas-java.git
```
2) Abra no seu IDE Java favorito (IntelliJ, Eclipse, VSCode com extensões etc.)

3) Execute a classe Main.java

4) Use o menu interativo no console para navegar pelas funcionalidades


## 👨‍💻 Autor
### Leonardo Ferreira
Estudante de Engenharia de Software, focado em desenvolvimento back-end com Java.

📫 https://www.linkedin.com/in/leonardoferreirabarros/
