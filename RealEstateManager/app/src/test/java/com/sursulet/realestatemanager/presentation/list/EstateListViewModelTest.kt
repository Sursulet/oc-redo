package com.sursulet.realestatemanager.presentation.list

import com.sursulet.realestatemanager.data.repository.FakeEstateRepository
import org.junit.Before
import org.junit.Test

class EstateListViewModelTest {

    private lateinit var viewModel: EstateListViewModel

    @Before
    fun setup() {
        viewModel = EstateListViewModel(FakeEstateRepository())
    }

    @Test
    fun `insert estate with empty field return error`() {}
}