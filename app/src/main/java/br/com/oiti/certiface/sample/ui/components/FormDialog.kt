package br.com.oiti.certiface.sample.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import br.com.oiti.certiface.sample.viewmodel.MainViewModel
import kotlin.text.toIntOrNull

@Composable
fun FormDialog(onDismiss: () -> Unit, onSave: () -> Unit, viewModel: MainViewModel) {
    var ticket by remember { mutableStateOf("") }
    var org by remember { mutableStateOf("") }
    var branch by remember { mutableStateOf("") }
    var key by remember { mutableStateOf("") }
    var subOrg by remember { mutableStateOf("") }
    var group by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = {
            Text(text = "Configuração Certiface User")
        },
        text = {
            Column {
                OutlinedTextField(
                    value = ticket,
                    onValueChange = { ticket = it },
                    label = { Text("Ticket") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = org,
                    onValueChange = { org = it },
                    label = { Text("Org") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = branch,
                    onValueChange = { branch = it },
                    label = { Text("Branch") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = key,
                    onValueChange = { key = it },
                    label = { Text("Key") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = subOrg,
                    onValueChange = { subOrg = it },
                    label = { Text("subOrg") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = group,
                    onValueChange = { group = it },
                    label = { Text("group") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    viewModel.customTicket = ticket
                    viewModel.xKey = key
                    viewModel.org = org.toIntOrNull()
                    viewModel.branch = branch.toIntOrNull()
                    viewModel.subOrg = subOrg.toIntOrNull()
                    viewModel.group = group.toIntOrNull()
                    onSave()
                    onDismiss()
                }
            ) {
                Text("Salvar")
            }
        },
        dismissButton = {
            Button(onClick = { onDismiss() }) {
                Text("Cancelar")
            }
        }
    )
}
