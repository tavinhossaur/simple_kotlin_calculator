package com.example.apptrabkotlin

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.example.apptrabkotlin.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression // ------------- Biblioteca de código para equações e expressões matemáticas
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {                   // Activity Main
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)              // Activity (Tela)

        button_limpar.setOnClickListener{                   // Botão para limpar a textbox
            input.text = ""                                 // Input: entradas do usuário
            output.text = ""                                // Output: saídas do app
        }

        button_parenteses_esq.setOnClickListener {
            input.text = addInputText("(")        // Botão que insere o "("
        }
        button_parenteses_dir.setOnClickListener {
            input.text = addInputText(")")        // Botão que insere o ")"
        }
        button_0.setOnClickListener {
            input.text = addInputText("0")        // Botão que insere o "0"
        }
        button_1.setOnClickListener {
            input.text = addInputText("1")        // Botão que insere o "1"
        }
        button_2.setOnClickListener {
            input.text = addInputText("2")        // Botão que insere o "2"
        }
        button_3.setOnClickListener {
            input.text = addInputText("3")        // Botão que insere o "3"
        }
        button_4.setOnClickListener {
            input.text = addInputText("4")        // Botão que insere o "4"
        }
        button_5.setOnClickListener {
            input.text = addInputText("5")        // Botão que insere o "5"
        }
        button_6.setOnClickListener {
            input.text = addInputText("6")        // Botão que insere o "6"
        }
        button_7.setOnClickListener {
            input.text = addInputText("7")        // Botão que insere o "7"
        }
        button_8.setOnClickListener {
            input.text = addInputText("8")        // Botão que insere o "8"
        }
        button_9.setOnClickListener {
            input.text = addInputText("9")        // Botão que insere o "9"
        }
        button_espaco.setOnClickListener {
            input.text = addInputText(" ")        // Botão que insere o " " (espaço)
        }
        button_divisao.setOnClickListener {
            input.text = addInputText("÷")        // Botão que insere o "÷"
        }
        button_multiplicacao.setOnClickListener {
            input.text = addInputText("×")        // Botão que insere o "×"
        }
        button_subtracao.setOnClickListener {
            input.text = addInputText("-")        // Botão que insere o "-"
        }
        button_adicao.setOnClickListener {
            input.text = addInputText("+")        // Botão que insere o "+"
        }
        button_igual.setOnClickListener {
            showResult()                                    // Botão que chama a função que exibe o resultado
            input.text = ""
        }

    }

    private fun addInputText(buttonValue: String): String {
        return "${input.text}$buttonValue"                  // Função que permite inserir os caracteres na caixa de texto
    }

    private fun getInputExpression(): String {
        var expression = input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")            // Função que da replace nos caracteres
        return expression                                                            // e os interpreta como expressões na biblioteca de código de equações matemáticas
    }

    private fun showResult() {                                                       // Função que mostra o resultado
        try{
            val expression = getInputExpression()
            val resultado = Expression(expression).calculate()  // calculate() é quem faz o calculo a partir das expressões matemáticas
            if (resultado.isNaN()) {                            // Se o resultado for NaN (Not a Number), ele exibirá uma mensagem com o texto "Erro"
                //Mostrar mensagem de erro                      // Ou seja, se o usuário inserir qualquer caractere inválido, a mensagem de erro irá aparecer
                output.text = "Erro"
                output.setTextColor(ContextCompat.getColor(this, R.color.background_red))   // A cor definida para a mensagem de erro é vermelha
            }else{
                //Mostrar resultado                                                                   // Caso contrário, mostrar o resultado com a seguinte formatação
                output.text = DecimalFormat("0.######").format(resultado).toString()           // Formato Decimal "0.######"
                output.setTextColor(ContextCompat.getColor(this, R.color.background_green))    // A cor definida para mensagem do resultado é verde
            }
        } catch (e: Exception) {
            //Mostrar mensagem de erro                                                                // No caso de qualquer outro erro, como divisão por 0,
            output.text = "Erro"                                                                      // ele também mostrará uma mensagem de erro
            output.setTextColor(ContextCompat.getColor(this, R.color.background_red))          // A cor definida para a mensagem de erro é vermelha
        }
    }
} // Fim da Main Activity

