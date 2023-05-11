package ni.edu.uca.sistematicopersistencia.data.database.dao

import androidx.room.*
import ni.edu.uca.sistematicopersistencia.data.database.entities.EntityUsuario

@Dao
interface UsuarioDao {

    @Query("SELECT * FROM usuario ORDER BY USER ASC")
    suspend fun obtenerUsuarios(): MutableList<EntityUsuario>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun agregarUsuario(usuario: EntityUsuario)

    @Update
    suspend fun actualizarUsuario(usuario: EntityUsuario)

    @Delete
    suspend fun eliminarUsuario(usuario: EntityUsuario)
}
