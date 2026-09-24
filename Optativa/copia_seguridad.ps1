# ============================================
# COPIA DE SEGURIDAD + APAGADO DEL PC
# ============================================

# -----------------------------
# CONFIGURACIÓN
# -----------------------------

$Origen = "C:\Users\alumno\Desktop\2"
$Destino = "C:\Users\alumno\Desktop\2_copiaSeguridad"


# -----------------------------
# COMPROBAR CARPETA DE ORIGEN
# -----------------------------

if (-not (Test-Path -LiteralPath $Origen)) {

    Write-Host "ERROR: No existe la carpeta de origen:"
    Write-Host $Origen
    Write-Host ""
    Write-Host "El PC NO se apagará."

    Read-Host "Pulsa Enter para salir"

    exit 1
}


# -----------------------------
# CREAR CARPETA DE DESTINO
# -----------------------------

if (-not (Test-Path -LiteralPath $Destino)) {

    New-Item -ItemType Directory -Path $Destino -Force | Out-Null
}


# -----------------------------
# INFORMACIÓN DE LA COPIA
# -----------------------------

Write-Host "============================================"
Write-Host "       INICIANDO COPIA DE SEGURIDAD"
Write-Host "============================================"

Write-Host "Origen:  $Origen"
Write-Host "Destino: $Destino"
Write-Host ""


# -----------------------------
# REALIZAR COPIA CON ROBOCOPY
# -----------------------------

robocopy `
    $Origen `
    $Destino `
    /E `
    /XO `
    /FFT `
    /R:2 `
    /W:5 `
    /COPY:DAT `
    /DCOPY:T `
    /NP `
    /TEE


# Guardar código de salida de Robocopy
$Resultado = $LASTEXITCODE


# -----------------------------
# COMPROBAR RESULTADO
# -----------------------------

Write-Host ""
Write-Host "============================================"

# Robocopy considera los códigos 0-7
# como resultados correctos.

if ($Resultado -le 7) {

    Write-Host "COPIA COMPLETADA CORRECTAMENTE."
    Write-Host "El ordenador se apagará en 10 segundos..."
    Write-Host "============================================"

    # Esperar 10 segundos
    Start-Sleep -Seconds 10


    # -----------------------------
    # APAGAR WINDOWS
    # -----------------------------

    shutdown.exe /s /t 0

}
else {

    Write-Host "ERROR DURANTE LA COPIA."
    Write-Host "Código de Robocopy: $Resultado"
    Write-Host ""
    Write-Host "EL ORDENADOR NO SE APAGARÁ."
    Write-Host "============================================"

    Read-Host "Pulsa Enter para salir"

    exit $Resultado
}