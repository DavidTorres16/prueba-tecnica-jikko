function encontrarIndices(nums, objetivo) {
    let mapa = new Map();  // Para almacenar los valores y sus índices.

    for (let i = 0; i < nums.length; i++) {
        let complemento = objetivo - nums[i];

        if (mapa.has(complemento)) {
            return [mapa.get(complemento), i];  // Devuelve los índices.
        }

        mapa.set(nums[i], i);  // Almacena el número y su índice.
    }

    return null;  // Si no se encuentran los números que sumen el objetivo.
}

let nums = [2, 9, 11, 3];
let objetivo = 20;
console.log(encontrarIndices(nums, objetivo)); 