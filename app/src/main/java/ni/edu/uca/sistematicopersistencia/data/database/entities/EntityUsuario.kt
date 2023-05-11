package ni.edu.uca.sistematicopersistencia.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TblUsuario")
data class EntityUsuario(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val user: String
)