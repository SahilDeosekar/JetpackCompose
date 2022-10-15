package com.example.exercise1.viewmodel

import androidx.lifecycle.ViewModel
import com.example.exercise1._description
import com.example.exercise1.model.Products

class DescriptionViewmodel: ViewModel() {
    var description: Products = _description
}