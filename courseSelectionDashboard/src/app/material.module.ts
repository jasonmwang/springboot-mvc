import { NgModule } from '@angular/core'
import { CommonModule } from '@angular/common'
import { MatButtonModule, MatFormFieldModule, MatInputModule, MatIconModule, MatCardModule, MatOptionModule, MatSelectModule } from '@angular/material'

@NgModule({
    imports: [
        MatButtonModule, MatFormFieldModule, MatInputModule, MatIconModule, MatCardModule, MatOptionModule, MatSelectModule
    ],
    exports: [
        MatButtonModule, MatFormFieldModule, MatInputModule, MatIconModule, MatCardModule, MatOptionModule, MatSelectModule
    ]
})

export class MaterialModule{}