package com.example.introduction.infraestructure.adapters.mappers;

import com.example.introduction.domain.models.Library;
import com.example.introduction.infraestructure.controllers.dto.in.LibraryDTO;
import com.example.introduction.infraestructure.controllers.dto.in.LibraryUpdateDTO;

import java.util.List;
import java.util.stream.Collectors;

public class LibraryMapper {


    public static LibraryDTO toLibraryCreationDTO(Library library) {
        if (library == null) {
            return null;
        }

        return new LibraryDTO(
                library.getName(),
                library.getIsActive()
        );
    }


    public static Library toLibrary(LibraryDTO libraryDTO) {
        if (libraryDTO == null) {
            return null;
        }

        return new Library(
                null,
                libraryDTO.getName(),
                libraryDTO.getIsActive(),
                null
        );
    }

    public static Library toLibrary(LibraryUpdateDTO libraryUpdateDTO) {
        if (libraryUpdateDTO == null) {
            return null;
        }

        return new Library(
                libraryUpdateDTO.getId(),
                libraryUpdateDTO.getName(),
                libraryUpdateDTO.getIsActive(),
                null
        );
    }


    public static List<LibraryDTO> toLibraryCreationDTOList(List<Library> libraries) {
        if (libraries == null) {
            return null;
        }

        return libraries.stream()
                .map(LibraryMapper::toLibraryCreationDTO)
                .collect(Collectors.toList());
    }


    public static List<Library> toLibraryList(List<LibraryDTO> libraryDTOS) {
        if (libraryDTOS == null) {
            return null; // Manejo de caso nulo
        }

        return libraryDTOS.stream()
                .map(LibraryMapper::toLibrary)
                .collect(Collectors.toList());
    }
}
