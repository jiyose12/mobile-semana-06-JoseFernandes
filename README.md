# mobile-semana-06-JoseFernandes
# Aplicativo
Lista de Desejos

# DESCRIÇÃO
Desenvolva um aplicativo para registrar os desejos de compras do usuário. Para cada desejo devem ser
registrados: descrição e valor.

# REQUISITOS
O aplicativo deverá possuir 02 (duas) telas. A seguir:
# Tela 01:
Apresentar uma lista dos desejos cadastrados e oferecer, através de um FloatingActionButton, a
possiblidade de chamar a tela 2 (formulário para cadastro) para inserir um novo desejo.
# Tela 02:
Apresentar os campos necessários para cadastrar um novo desejo.
A Tela 02 deverá instanciar um objeto do tipo “Desejo”, a seguir, e retornar para a lista que estará sendo
persistida na Tela 01.
```
import java.io.Serializable
class Desejo: Serializable {
var descricao: String
var valor: Float
constructor(descricao: String, valor: Float){
this.descricao = descricao
this.valor = valor
}
override fun toString(): String {
return "${this.descricao} - R$ ${this.valor}"
}
}
```
