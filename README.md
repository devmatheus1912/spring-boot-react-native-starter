# spring-boot-react-native-starter

API REST Java + App Mobile iOS e Android com autenticação JWT

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2.5-brightgreen?style=flat-square)
![React Native](https://img.shields.io/badge/React_Native-Expo_54-blue?style=flat-square)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue?style=flat-square)
![JWT](https://img.shields.io/badge/Auth-JWT-purple?style=flat-square)
![License](https://img.shields.io/badge/License-MIT-lightgrey?style=flat-square)

---

## Sobre o projeto

Starter kit construído do zero para quem quer desenvolver um aplicativo
mobile conectado a um servidor Java. A estrutura foi organizada para
crescer junto com o projeto — você começa com autenticação e navegação
prontas e vai adicionando funcionalidades sem reescrever o que já funciona.

Nasceu de uma necessidade real: toda vez que um novo app precisava ser
criado, semanas eram gastas só na configuração básica antes de qualquer
funcionalidade ser escrita.

## Tecnologias

**Backend**
- Java 17 + Spring Boot 3.2.5
- Spring Security + JWT (autenticação stateless)
- Spring Data JPA + PostgreSQL
- CORS configurado para web e mobile
- Lombok + Gradle

**Mobile**
- React Native + Expo SDK 54
- React Navigation 7
- Axios + AsyncStorage

## Status

| Módulo | Status |
|---|---|
| Autenticação JWT | ✅ Concluído |
| Banco de dados PostgreSQL | ✅ Concluído |
| App mobile com login e cadastro | ✅ Concluído |
| Dashboard com navegação | ✅ Concluído |
| Tela de treinos com listagem | ✅ Concluído |
| Senhas removidas da resposta da API | ✅ Concluído |
| Configuração CORS para web e mobile | ✅ Concluído |
| Tela de detalhes do treino | 🔧 Em desenvolvimento |
| CRUD de perfil com foto | 🔧 Em desenvolvimento |
| Refresh token | 🔧 Em desenvolvimento |
| Notificações push | 📋 Planejado |
| Testes automatizados | 📋 Planejado |
| Deploy na nuvem | 📋 Planejado |
| Publicação Play Store e App Store | 📋 Planejado |

## Como rodar

### Pré-requisitos

- IntelliJ IDEA
- JDK 17+
- PostgreSQL
- Node.js LTS
- Expo Go no celular

### Backend

1. Crie o banco de dados no pgAdmin: `starter_db`
2. Copie o arquivo de configuração:

```bash
cp src/main/resources/application.properties.example \
   src/main/resources/application.properties
```

3. Preencha com sua senha do PostgreSQL
4. Rode no IntelliJ com `Shift + F10`

> As tabelas são criadas automaticamente pelo Hibernate na primeira execução.

### App Mobile

```bash
cd TAPerformanceApp2
npm install
npx expo start --clear
```

Escaneie o QR Code com o Expo Go. O celular e o computador
precisam estar na mesma rede Wi-Fi.

Para abrir no navegador pressione `w` após o Expo iniciar.

## Endpoints

| Método | Rota | Descrição | Auth |
|---|---|---|---|
| POST | `/api/auth/register` | Cadastrar usuário | Não |
| POST | `/api/auth/login` | Login e token JWT | Não |
| GET | `/api/treinos/aluno/{id}` | Treinos do aluno | Bearer Token |
| POST | `/api/treinos` | Criar treino | Bearer Token |
| PUT | `/api/treinos/{id}` | Atualizar treino | Bearer Token |
| DELETE | `/api/treinos/{id}` | Deletar treino | Bearer Token |

### Exemplo de cadastro

```json
POST /api/auth/register
{
  "nome": "Maria Silva",
  "email": "maria@email.com",
  "senha": "suasenha123",
  "role": "ALUNO"
}
```

### Exemplo de login

```json
POST /api/auth/login
{
  "email": "maria@email.com",
  "senha": "suasenha123"
}

→ { "token": "eyJhbGciOiJIUzI1NiJ9..." }
```

## Segurança

- Senhas criptografadas com BCrypt
- Autenticação via JWT com validade de 24 horas
- Rotas protegidas por token
- Dados sensíveis removidos das respostas da API
- CORS configurado por origem

## Roadmap

### ✅ Concluído
- Autenticação completa com JWT
- Banco de dados com criação automática de tabelas
- App mobile com telas de login, cadastro e dashboard
- API REST com CRUD de treinos
- Tela de treinos com listagem por aluno
- Configuração CORS para web e mobile
- Senhas removidas das respostas da API

### 🔧 Em desenvolvimento
- Tela de detalhes do treino com exercícios
- CRUD de perfil com foto de avatar
- Refresh token automático

### 📋 Planejado
- Tela de dieta e plano alimentar
- Notificações push com Firebase
- Upload de fotos com Amazon S3
- Testes unitários com JUnit e Mockito
- Deploy automático com GitHub Actions
- Publicação na Play Store e App Store

## Como contribuir

1. Faça um fork do repositório
2. Crie uma branch: `git checkout -b feature/nome-da-feature`
3. Commit com mensagem descritiva: `git commit -m "feat: descricao"`
4. Push: `git push origin feature/nome-da-feature`
5. Abra um Pull Request

## Licença

Distribuído sob a licença MIT. Veja `LICENSE` para mais informações.
