package com.openclassrooms.notes.service

import com.openclassrooms.notes.data.model.Note

/**
 * Implementation of the [NotesApiService] interface that stores note in local
 */
class LocalNotesApiService : NotesApiService {

    override fun addNote(note: Note) {
        TODO("Not yet implemented")
    }

    override fun getAllNotes(): List<Note> {
        return listOf(
            Note(title = "La vie est belle", description = "La vie est belle, pleine de choses à voir et à faire. Profitez de chaque moment et ne laissez jamais personne vous dire que vous ne pouvez pas faire ce que vous voulez."),
            Note(title="Ne laissez personne vous dire que vous ne pouvez pas faire quelque chose.", description = "Croyez en vous et en vos capacités. Ne laissez personne vous dire que vous ne pouvez pas faire quelque chose. Suivez vos rêves et ne laissez rien vous arrêter."),
            Note(title="Suivez vos rêves", description = "Ne laissez rien vous arrêter de suivre vos rêves. Travaillez dur et ne vous découragez jamais. Vos rêves sont à votre portée, alors n'ayez pas peur de les poursuivre."),
            Note(title = "Soyez gentil avec les autres", description = "Le monde a besoin de plus de gentillesse. Soyez gentil avec les autres, même si ce n'est pas facile. La gentillesse peut faire une grande différence dans le monde."),
            Note(title = "Aidez les autres", description = "Le monde est un meilleur endroit lorsque nous travaillons ensemble. Aidez les autres, même si c'est juste un petit geste. Chaque geste compte."),
            Note(title = "Soyez reconnaissant pour ce que vous avez.", description = "Il y a toujours quelqu'un qui a moins que vous. Soyez reconnaissant pour ce que vous avez, même si ce n'est pas grand-chose. La gratitude peut vous rendre heureux et épanoui."),
            Note(title = "Vivez le moment présent", description = "Ne vous inquiétez pas du passé et ne vous inquiétez pas de l'avenir. Vivez le moment présent et profitez de chaque minute. Le moment présent est tout ce que vous avez"),
            Note(title = "Prenez soin de vous", description = "Mangez sainement, faites de l'exercice et dormez suffisamment. Prenez soin de votre corps et de votre esprit. Vous êtes votre meilleur atout."),
            Note(title = "Passez du temps avec vos proches", description = "Ils sont les plus importants dans votre vie. Passez du temps avec vos proches et montrez-leur à quel point vous les aimez. Ils sont votre famille et vos amis."),
            Note(title = "Risez et amusez-vous.", description = "La vie est trop courte pour être sérieuse tout le temps. Riez et amusez-vous. Passez du temps à faire les choses que vous aimez."),
        )
    }
}