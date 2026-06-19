Attribute VB_Name = "Module1"
Public R As Long
Public i As Integer


Sub lastRow()
    R = Cells(Rows.Count, 1).End(xlUp).Row
End Sub


Sub adD23()
    Cells(i, 4) = Cells(i, 2) + Cells(i, 3)
End Sub

Sub adds(a As Integer, b As Integer, c As Integer)
    Cells(i, c) = Cells(i, a) + Cells(i, b)
End Sub


Sub miN23()
     Cells(i, 4) = Cells(i, 2) - Cells(i, 3)
End Sub

Sub mins(a As Integer, b As Integer, c As Integer)
    Cells(i, c) = Cells(i, a) - Cells(i, b)
End Sub


Sub muL23()
     Cells(i, 4) = Cells(i, 2) * Cells(i, 3)
End Sub

Sub muls(a As Integer, b As Integer, c As Integer)
    Cells(i, c) = Cells(i, a) * Cells(i, b)
End Sub


Sub diV23()
     Cells(i, 4) = Cells(i, 2) / Cells(i, 3)
End Sub

Sub divs(a As Integer, b As Integer, c As Integer)
    Cells(i, c) = Cells(i, a) / Cells(i, b)
End Sub


Sub diR23()
     Cells(i, 4) = Cells(i, 2) \ Cells(i, 3)
End Sub

Sub dirs(a As Integer, b As Integer, c As Integer)
    Cells(i, c) = Cells(i, a) \ Cells(i, b)
End Sub


Sub reM23()
     Cells(i, 5) = Cells(i, 2) Mod Cells(i, 3)
End Sub

Sub rems(a As Integer, b As Integer, c As Integer)
    Cells(i, c) = Cells(i, a) Mod Cells(i, b)
End Sub
