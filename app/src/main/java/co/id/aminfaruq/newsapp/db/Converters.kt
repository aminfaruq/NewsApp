package co.id.aminfaruq.newsapp.db

import androidx.room.TypeConverter
import co.id.aminfaruq.newsapp.models.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}