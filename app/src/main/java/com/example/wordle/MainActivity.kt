package com.example.wordle

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wordle.FourLetterWordList.getRandomFourLetterWord
import com.example.wordle.FourLetterWordList.getRandomFourLetterWordAnimal
import com.example.wordle.FourLetterWordList.getRandomFourLetterWordFood
import com.example.wordle.FourLetterWordList.getRandomFourLetterWordName


var wordToGuess = getRandomFourLetterWord()
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Words the user guesses
        val userGuess1 = findViewById<TextView>(R.id.userGuess1)
        val userGuess2 = findViewById<TextView>(R.id.userGuess2)
        val userGuess3 = findViewById<TextView>(R.id.userGuess3)

        //Buttons
        val submitButton = findViewById<Button>(R.id.submitButton)
        val restartButton = findViewById<Button>(R.id.restartButton)
        val resetButton = findViewById<Button>(R.id.resetButton)

        //Spinner: Handles custom word lists
        val spinner = findViewById<Spinner>(R.id.spinner)
        val wordArray = arrayOf("Default Words","Animals","Names","Food")
        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,wordArray)
        spinner.adapter = adapter
        var wordList = "Default Words"

        //Others
        var answer = findViewById<TextView>(R.id.wordToGuess)
        var guessesLeft = findViewById<TextView>(R.id.guessesLeft)
        var winningStreak = findViewById<TextView>(R.id.winningStreak)
        var editText = findViewById<EditText>(R.id.editText)
        val star = findViewById<ImageView>(R.id.star)

        var guesses = 3
        var count = 0
        var streak = 0
        guessesLeft.text = "$guesses guesses left."

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, "${adapterView?.getItemAtPosition(position).toString()} list selected. Word will generate after a reset.", Toast.LENGTH_SHORT).show()
                wordList = adapterView?.getItemAtPosition(position).toString()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        //Submit button clicked; check guessed word against generated word.
        submitButton.setOnClickListener {
            hideKeyboard()
            //If guess is non-alphabetical or not 4 letters long
            var flag=0
            var guess: String = editText.text.toString().uppercase()
            if (guess.length == 4) {
                for (ch in guess) {
                    if (!ch.isLetter()) {
                        editText.setError("Word must only contain letters.")
                        editText.setText("")
                        flag = 1
                        break
                    }
                }
            } else { editText.setError("Enter a 4-letter word."); editText.setText(""); flag=1;  }
            //Flag for handling !=4 letters, not alphabetical
            if (flag==0) {
                guesses--
                guessesLeft.text = "$guesses guesses left."
                count++
                //Correctly guessed word
                if (guess == wordToGuess) {
                    answer.text = wordToGuess
                    streak++
                    count = 0
                    guesses = 3
                    submitButton.visibility = View.INVISIBLE
                    restartButton.visibility = View.VISIBLE
                    star.visibility=View.VISIBLE
                    guessesLeft.text = ""
                    resetButton.setAlpha(.5f)
                    resetButton.setClickable(false)
                }
                when (count) {
                    1 -> userGuess1.text = checkGuess(guess)
                    2 -> userGuess2.text = checkGuess(guess)
                    3 -> userGuess3.text = checkGuess(guess)
                }
                //Run out of guesses
                if (count==3 && guess!=wordToGuess) {
                    answer.text = wordToGuess
                    streak = 0
                    count = 0
                    guesses = 3
                    submitButton.visibility = View.INVISIBLE
                    restartButton.visibility = View.VISIBLE
                    resetButton.setAlpha(.5f)
                    resetButton.setClickable(false)
                }
                editText.setText("")
                //Restart button clicked. Start a new game, +streak
                restartButton.setOnClickListener {
                    answer.text = ""
                    userGuess1.text = ""
                    userGuess2.text = ""
                    userGuess3.text = ""
                    submitButton.visibility = View.VISIBLE
                    restartButton.visibility = View.INVISIBLE
                    resetButton.setAlpha(1f)
                    resetButton.setClickable(true)
                    star.visibility=View.INVISIBLE
                    winningStreak.text = "Streak: $streak"
                    guessesLeft.text = "3 guesses left."
                    wordToGuess = when (wordList) {
                        "Names" -> getRandomFourLetterWordName()
                        "Animals" -> getRandomFourLetterWordAnimal()
                        "Food" -> getRandomFourLetterWordFood()
                        else -> getRandomFourLetterWord()
                    }
                }
            }
        }
        //Reset button clicked. Starts a new game, ends streak (no win).
        resetButton.setOnClickListener {
            streak = 0
            count = 0
            guesses = 3
            answer.text = ""
            userGuess1.text = ""
            userGuess2.text = ""
            userGuess3.text = ""
            submitButton.visibility = View.VISIBLE
            restartButton.visibility = View.INVISIBLE
            star.visibility = View.INVISIBLE
            winningStreak.text = "Streak: $streak"
            guessesLeft.text = "3 guesses left."
            if (wordList == "Names") wordToGuess = getRandomFourLetterWordName()
            else if (wordList == "Animals") wordToGuess = getRandomFourLetterWordAnimal()
            else if (wordList == "Food") wordToGuess = getRandomFourLetterWordFood()
            else wordToGuess = getRandomFourLetterWord()
        }
    }
    private fun checkGuess(guess: String) : Spannable {
        val sb: Spannable = SpannableString(guess)
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {       //correct letter + placement
                sb.setSpan(
                    ForegroundColorSpan(Color.GREEN),
                    i, i + 1,
                    Spannable.SPAN_EXCLUSIVE_INCLUSIVE
                )
            } else if (guess[i] in wordToGuess) {   //correct letter, incorrect placement
                sb.setSpan(
                    ForegroundColorSpan(Color.rgb(255,175,0)),  //orange
                    i, i + 1,
                    Spannable.SPAN_EXCLUSIVE_INCLUSIVE
                )
            } else {                                //incorrect letter + placement
                sb.setSpan(
                    ForegroundColorSpan(Color.RED),
                    i, i + 1,
                    Spannable.SPAN_EXCLUSIVE_INCLUSIVE
                )
            }

        }
        return sb
    }
    //https://stackoverflow.com/questions/41790357/close-hide-the-android-soft-keyboard-with-kotlin/41791472#41791472
    fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }
    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}