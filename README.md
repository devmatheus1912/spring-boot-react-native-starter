# spring-boot-react-native-starter

API REST Java + App Mobile iOS e Android com autenticação JWT

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2.5-green)
![React Native](https://img.shields.io/badge/React_Native-Expo_54-blue)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

---

## Sobre o projeto

Starter kit completo para quem quer construir um aplicativo mobile
conectado a um servidor Java. A estrutura foi organizada para crescer
junto com o projeto — você começa com os módulos prontos e vai
adicionando funcionalidades sem precisar reescrever o que já funciona.

Nasceu de uma necessidade real: toda vez que um novo app precisava ser
criado, semanas eram gastas só na configuração básica antes de qualquer
funcionalidade ser escrita.

## Tecnologias

**Backend**
- Java 17 + Spring Boot 3.2.5
- Spring Security + JWT (autenticação stateless)
- Spring Data JPA + PostgreSQL
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
````
   cp src/main/resources/application.properties.example
   src/main/resources/application.properties
````
3. Preencha com sua senha do PostgreSQL
4. Rode no IntelliJ com `Shift + F10`

### App Mobile

```bash
cd TAPerformanceApp2
npm install
npx expo start --clear
```

Escaneie o QR Code com o Expo Go. O celular e o computador
precisam estar na mesma rede Wi-Fi.

## Endpoints

| Método | Rota | Descrição | Auth |
|---|---|---|---|
| POST | /api/auth/register | Cadastrar usuário | Não |
| POST | /api/auth/login | Login e token JWT | Não |
| GET | /api/treinos/aluno/{id} | Treinos do aluno | Bearer Token |
| POST | /api/treinos | Criar treino | Bearer Token |

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

## Segurança

- Senhas criptografadas com BCrypt
- Autenticação via JWT com validade de 24 horas
- Rotas protegidas por token
- Banco de dados isolado por projeto

## Roadmap

### ✅ Concluído
- Autenticação completa com JWT
- Banco de dados com tabelas automáticas
- App mobile com telas de login, cadastro e dashboard
- API REST com endpoints de treinos

### 🔧 Em desenvolvimento
- CRUD de perfil com foto de avatar
- Refresh token automático
- Validação de campos com mensagens de erro

### 📋 Planejado
- Notificações push com Firebase
- Upload de fotos com Amazon S3
- Testes unitários e de integração
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
