package es.sixtema.handygym.ui.workouts.workoutContent.exercisesSearch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.sixtema.handygym.common.extensions.loadVideoImage
import es.sixtema.handygym.databinding.RowExerciseBinding
import es.sixtema.handygym.domain.models.Exercise
import es.sixtema.handygym.domain.models.Language


class ExercisesSearchAdapter(private val listener: (Exercise) -> Unit, private val exercises: List<Exercise>, private val language: String) : RecyclerView.Adapter<ExercisesSearchAdapter.ExercisesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ExercisesViewHolder(RowExerciseBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int {
        return exercises.size
    }

    override fun onBindViewHolder(holder: ExercisesViewHolder, position: Int) {
        holder.bind(exercises[position], language, listener)
    }

    class ExercisesViewHolder(val binding: RowExerciseBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(exercise: Exercise, language: String, listener: (Exercise) -> Unit) = with(binding) {
            if (language == Language.Spanish) {
                name.text = exercise.nameEs
                description.text = exercise.descriptionEs
            } else {
                name.text = exercise.nameEn
                description.text = exercise.descriptionEn
            }
            image.loadVideoImage(exercise.video)

            layout.setOnClickListener{listener(exercise)}
        }
    }
}