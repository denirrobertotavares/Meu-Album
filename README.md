# Meu-Album
Projeto SPRING BOOT Básico<br/><br/>
Para instalação do pacote siga corretamente as instruções.<br/><br/>
1- Abra o arquivo ScriptSQL e siga os passos para criação do banco.<br/><br/>
2- O código fonte foi desenvolvido, compilado e testado por meio da ferramenta STS da Spring. Por se tratar de um fonte maven pode ser importado pelo Eclipse e Netbeans nas suas versões mais atuais. Os testes de massa foram executados no sistema SoapUI 5.5.0 sem quais problemas.<br/><br/>
3- Links para teste:<br/>
a- http://localhost:8081/artista/listAllArtista -> apresentará todo JSON dos dados armazenados na base;<br/>
b- http://localhost:8081/artista/listAllArtista?paginaNum=0&paginaLinhas=2 - apresentará o resultado em modo paginação;<br/>
c- http://localhost:8081/artista/insertArtista -> fará o insert de dados na base.<br/>
Ex.:<br/>
<pre>
{
  "descricao" : "Nome do Artista/Banda"
}
</pre>
d- http://localhost:8081/artista/updateArtista -> fará o update de dados na base.<br/>
Ex.:<br/>
<pre>
{
"codArtista" : 1
"descricao" : "Novo Nome do Artista/Banda"
}
</pre>
e- http://localhost:8081/artista/deleteArtista -> fará o delete do modelo de dados selecionado na base.<br/>
Ex.:<br/>
<pre>
{
"codArtista" : 1
"descricao" : "Nome do Artista/Banda"
}
</pre>
