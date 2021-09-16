JWT Setup
=========

This application has been tested with the secret: hello_this_is_my_secret_for_jwt_authentication

Header:

{
  "alg": "HS256",
  "typ": "JWT",
  "kid": "extranet"
}

Payload:

{
  "name": "Mihael",
  "locale": "en_EN",
  "email": "mihael@rpgnextgen.com",
  "iss": "extranet-auth-api",
  "upn": "mihael@rpgnextgen.com",
  "sub": "mihael@rpgnextgen.com",
  "iat": 1631772641,
  "exp": 1633859041
}

Generated token (by jwt.io):

eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6ImV4dHJhbmV0In0.eyJuYW1lIjoiTWloYWVsIiwibG9jYWxlIjoiZW5fRU4iLCJlbWFpbCI6Im1paGFlbEBycGduZXh0Z2VuLmNvbSIsImlzcyI6ImV4dHJhbmV0LWF1dGgtYXBpIiwidXBuIjoibWloYWVsQHJwZ25leHRnZW4uY29tIiwic3ViIjoibWloYWVsQHJwZ25leHRnZW4uY29tIiwiaWF0IjoxNjMxNzcyNjQxLCJleHAiOjE2MzM4NTkwNDF9.3RywpB_h9Bqqv9Hn4QbqMe99yDJ6GOzHpCGNGLW7_w0

Result with Helidon 2.3.3
-------------------------

It seems that the JwtOctet class does not calculate the same signature as jwt.io even though the algorithm, header, payload and secret are the same.

2021.09.16 09:15:12 FINEST AUDIT Thread[helidon-1,5,helidon-thread-pool-2]: FAILURE authn.authenticate 566c1231-17eb-40e7-b5e7-e9e0ca520f7d:1  io.helidon.common.context.Contexts runInContext Contexts.java 117 :: "Provider io.helidon.microprofile.jwt.auth.JwtAuthProvider. Message: FATAL: Signature of JWT token is not valid, based on alg: HS256, kid: extranet at extranet(HS256)"
