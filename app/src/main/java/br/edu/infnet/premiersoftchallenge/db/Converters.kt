package br.edu.infnet.premiersoftchallenge.db

import androidx.room.TypeConverter
import br.edu.infnet.premiersoftchallenge.models.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String{
       return source.name
    }
    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name,name)
    }




}