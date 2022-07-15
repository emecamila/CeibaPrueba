package com.example.ceibaprueba.domain

import com.example.ceibaprueba.data.repository.UserRepository
import com.example.ceibaprueba.domain.model.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.mockito.MockitoAnnotations

class GetUsersUseCaseTest {

    @MockK
    private lateinit var userRepository: UserRepository

    private lateinit var getUsersUseCase: GetUsersUseCase

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        getUsersUseCase = GetUsersUseCase(userRepository)
    }

    @Test
    fun `cuando la base de datos no tiene registros de usuario se debe consultar el api`() =
        runBlocking {
            // Given
            coEvery { userRepository.getAllUsersFromDb() } returns emptyList()
            // When
            getUsersUseCase()
            // Then
            coVerify(exactly = 1) { userRepository.getAllUsersFromApi() }
        }

    @Test
    fun `cuando se obtienen registros de usuario del api, se obtienen los valores directamente del api`() =
        runBlocking {
            //Given
            val myList = listOf(
                User(
                    11,
                    "Camila Arbelaez",
                    "ahh.okaay",
                    "arbelaez.mag@gmail.com",
                    "3174494842",
                    "www.camila.com"
                )
            )
            coEvery { userRepository.getAllUsersFromApi() } returns myList

            //When
            val response = getUsersUseCase()

            //Then
            coVerify(exactly = 1) { userRepository.clearUsers() }
            coVerify(exactly = 1) { userRepository.insertAll(any()) }
            coVerify(exactly = 0) { userRepository.getAllUsersFromDb() }
            assert(response == myList)
        }

    @Test
    fun `cuando se obtienen registros de usuario de la base de datos, se obtienen los valores directamente de la base de datos`() =
        runBlocking {
            //Given
            val myList = listOf(
                User(
                    11,
                    "Camila Arbelaez",
                    "ahh.okaay",
                    "arbelaez.mag@gmail.com",
                    "3174494842",
                    "www.camila.com"
                )
            )
            coEvery { userRepository.getAllUsersFromDb() } returns myList

            //When
            val response = getUsersUseCase()

            //Then
            coVerify(exactly = 1) { userRepository.clearUsers() }
            coVerify(exactly = 1) { userRepository.insertAll(any()) }
            coVerify(exactly = 0) { userRepository.getAllUsersFromApi() }
            assert(response == myList)
        }

}