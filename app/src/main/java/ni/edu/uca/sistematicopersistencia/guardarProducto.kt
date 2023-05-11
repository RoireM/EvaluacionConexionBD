package ni.edu.uca.sistematicopersistencia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import ni.edu.uca.sistematicopersistencia.data.database.BaseDatos
import ni.edu.uca.sistematicopersistencia.data.database.entities.EntityProducto
import ni.edu.uca.sistematicopersistencia.databinding.FragmentGuardarProductoBinding
import java.lang.Double.parseDouble
import java.lang.Float.parseFloat
import java.lang.Integer.parseInt

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class guardarProducto : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentGuardarProductoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGuardarProductoBinding.inflate(inflater, container, false)
        binding.btnGuardar.setOnClickListener {
            val nombre = binding.nombre.text.toString()
            val precio = parseDouble(binding.precio.text.toString())
            val existencias = parseInt(binding.existencia.text.toString())
            val producto = EntityProducto(0, nombre, precio, existencias)

            lifecycleScope.launch {
                BaseDatos.obtBaseDatos(this@guardarProducto.requireContext()).productoDao().insertarReg(producto)
            }
            // BaseDatos(this@guardarProducto).productoDao().insertarReg(nombre)

        }
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment guardarProducto.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            guardarProducto().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}