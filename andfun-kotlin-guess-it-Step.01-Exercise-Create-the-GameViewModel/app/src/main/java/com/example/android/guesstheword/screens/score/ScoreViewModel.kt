package com.example.android.guesstheword.screens.score

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class ScoreViewModel(finalScore: Int) : ViewModel() {

	// The current score
	private val _finalScore = MutableLiveData<Int>()
	val finalScore : LiveData<Int>
		get() = _finalScore

	private val _eventPlayAgain = MutableLiveData<Boolean>()
	val eventPlayAgain : LiveData<Boolean>
		get() = _eventPlayAgain

	init {
		Timber.i("ScoreViewModel created!")
		_finalScore.value = finalScore
		_eventPlayAgain.value = false
		Timber.i("Final score is %s", finalScore)
	}

	override fun onCleared() {
		super.onCleared()
		Timber.i("ScoreViewModel destroyed!")
	}

	fun onGamePlayAgainButtonClicked() {
		_eventPlayAgain.postValue(true)
	}
}