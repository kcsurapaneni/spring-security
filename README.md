# spring-security
It is a learning &amp; practice repository to understand and work on spring security

## Encoding, Encryption &amp; Hashing

### Encoding
- It will follow a certain rule to encode and decode the input &amp; output.
  - Ex: Caesar cipher, Base-64, etc.,
- It will be bidirectional, i.e., from input we can derive output and vice versa
### Encryption
- It should have a private key along with certain rule to decode the input.
- It is also bidirectional
### Hashing
- Major difference with hashing is it is unidirectional. For the given output we never identify the input. That is the reason, we should store all the passwords as hashed ones instead of plain text. So, even if the data breach happened they were not able to fetch the actual password.
- MD5 is on of the old technique to perform this, but it is not secure anymore as we can get the input based on output.
- With MD5 we have another concern `Rainbow Table Attacks`.
## c1-basic-auth

- After adding **web** and **security** modules to the [pom.xml](/pom.xml) it will automatically generate a random UUID as the password.
  - Spring follows `convention over configuration` design philosophy. So, it will generate the password by looking into the structure of the code, in this case `security` module in the pom.xml.
- After having our own InMemoryUserDetailsManager, we can get rid of following log statement
```
WARN 45386 --- [           main] .s.s.UserDetailsServiceAutoConfiguration : 

Using generated security password: 49266a79-c52b-4fec-b3e7-32ff11f6837b

This generated password is for development use only. Your security configuration must be updated before running your application in production.
```