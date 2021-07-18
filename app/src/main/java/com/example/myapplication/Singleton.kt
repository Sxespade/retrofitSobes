package com.example.myapplication

object Singleton {

    private var session: String? = null

    fun setSession(session: String?) {
        this.session = session
    }

    fun getSession(): String? {
        return session
    }
}