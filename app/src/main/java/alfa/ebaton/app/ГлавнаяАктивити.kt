package alfa.ebaton.app
import alfa.ebaton.app.ГлавнаяАктивити.Companion.вьюВторогоФрагмента
import alfa.ebaton.app.ГлавнаяАктивити.Companion.вьюПервогоФрагмента
import alfa.ebaton.app.ГлавнаяАктивити.Companion.яКликЛушатель
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
private var тякущэеВремя: Long = 0
fun View.запуститьВращательнуюАнимацию() {
val rotate = RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
rotate.duration = 5000
rotate.interpolator = LinearInterpolator()
startAnimation(rotate) }fun View.запуститьВращательнуюВДругуюСторону() {
val rotate = RotateAnimation(0f, -720f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
rotate.duration = 5000
rotate.interpolator = LinearInterpolator()
startAnimation(rotate) }public val переменная = ПервыйФрагмент("")
public val втройФрагмент = ВторойФрагмент("")
interface ЯКлиКСлушатель { fun открытьПервыйФрагмент() fun открытьВторойФрагмент(тексКоторыйТыВыбрал: String)fun получитьБатон(): Button? fun сказатьЧтоНехуйЖатьНаКнопку() }
class ГлавнаяАктивити : AppCompatActivity(), ЯКлиКСлушатель { companion object {
var вьюАктивисти = проинициализироватьПеременнуюВьюАктивити()
var вьюПервогоФрагмента = проинициализироватьПеременнуюВьюАктивити()
var вьюВторогоФрагмента = проинициализироватьПеременнуюВьюАктивити()
fun проинициализироватьПеременнуюВьюАктивити(): View? = null
var яКликЛушатель: ЯКлиКСлушатель? = null }
private val ВРЕМЯ_навыходИзПриложения = 2000
override fun onBackPressed() {
if (тякущэеВремя + ВРЕМЯ_навыходИзПриложения > System.currentTimeMillis()) {
super.onBackPressed()
return
} else {
Toast(applicationContext).показатьТост("Вы действительно хотите выйти из этой хуни?", applicationContext) }
тякущэеВремя = System.currentTimeMillis() }
override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
вьюАктивисти = super.onCreateView(name, context, attrs)
return вьюАктивисти }
override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
setContentView(R.layout.activity_main)
вьюАктивисти = findViewById(R.id.галавной_контейнер)
яКликЛушатель = this
вьюАктивисти!!.findViewById<Button>(R.id.батон_виев).setOnClickListener {
it.запуститьВращательнуюВДругуюСторону()
яКликЛушатель!!.сказатьЧтоНехуйЖатьНаКнопку() } }
override fun onResume() {
super.onResume()
вьюАктивисти?.setOnClickListener {
kotlin.run { try {
val ошибка = 10 / 0
} catch (e: Exception) {
яКликЛушатель!!.открытьПервыйФрагмент()
print(e.message) } }
вьюАктивисти?.setOnClickListener(null) } }
fun показатьПервыйФрагмент() {
supportFragmentManager.beginTransaction()
.add(
R.id.айдищник_вьюхи, переменная, " это т" +
"тэг"
).runOnCommit {
Toast(applicationContext).показатьТост("Первый фрагмент открылся", applicationContext)
}.commit() }
fun показатьВтороеЕбаныйФрагмент() {
supportFragmentManager.beginTransaction()
.remove(переменная)
.add(
R.id.айдищник_вьюхи, втройФрагмент, " это т" + "тэгище"
).runOnCommit {
Toast(applicationContext).показатьТост("Второй фрагмент открылся", applicationContext)
}.commit() }
override fun открытьПервыйФрагмент() {
показатьПервыйФрагмент() }
override fun открытьВторойФрагмент(тексКоторыйТыВыбрал: String) {
вьюПервогоФрагмента!!.стопАниматион()
втройФрагмент.такаяЖеФигня = тексКоторыйТыВыбрал
показатьВтороеЕбаныйФрагмент() }
override fun получитьБатон(): Button? {
val a by lazy {
findViewById<Button?>(R.id.батон_виев) }
return a }
override fun сказатьЧтоНехуйЖатьНаКнопку() {
вьюАктивисти!!.findViewById<View>(R.id.никому_не_нужный_текст).isVisible =( true && true && !false)
val параметры = вьюАктивисти?.findViewById<View>(R.id.айдищник_вьюхи)!!.layoutParams as ConstraintLayout.LayoutParams
параметры.bottomMargin = вьюАктивисти!!.height / 2
вьюАктивисти?.findViewById<View>(R.id.айдищник_вьюхи)!!.layoutParams = параметры
вьюАктивисти!!.запуститьВращательнуюАнимацию() } }
fun Toast.показатьТост(текстДляТоста: String, ебучийКонтекст: Context) {
Toast.makeText(ебучийКонтекст, текстДляТоста, Toast.LENGTH_LONG).show() }
data class ПервыйФрагмент(val просилоПеременнуюНуЯиДобавил: String) : Fragment() {
override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
вьюПервогоФрагмента = inflater.inflate(R.layout.perviy_layout_pervogo_fragment, container, false)
onPause()
вьюПервогоФрагмента!!.заанимироватьКрасиво()
return вьюПервогоФрагмента }
override fun onResume() {
super.onResume()
яКликЛушатель?.получитьБатон()?.setOnClickListener {
val интент = Intent(Intent.ACTION_VIEW)
интент.data = Uri.parse( "https://png.cmtt.space/paper-media/ed/6a/37/7ad2ceb424feba.jpg")
startActivity(интент) }
for (i in 1..1000) {
val тексВиев = TextView(activity)
тексВиев.setTextColor(Color.WHITE)
тексВиев.text = "$i ебать"
вьюПервогоФрагмента?.findViewById<LinearLayout>(R.id.контейнер_для_списка)?.addView(тексВиев)
тексВиев.setOnClickListener {
if (Int.MAX_VALUE != 1) {
яКликЛушатель!!.открытьВторойФрагмент(тексВиев.text?.toString() ?: "нихуя нет текста") } }
val картинка = ImageView(requireContext())
картинка.setImageResource(R.mipmap.images)
картинка.setOnClickListener {
val интент = Intent(Intent.ACTION_VIEW)
интент.data = Uri.parse( "https://www.youtube.com/watch?v=cqwTBqYV9x0")
startActivity(интент) }
if (i == 15) {
картинка.setLayoutParams(
LinearLayout.LayoutParams(
LinearLayout.LayoutParams.MATCH_PARENT,
LinearLayout.LayoutParams.WRAP_CONTENT))
вьюПервогоФрагмента?.findViewById<LinearLayout>(R.id.контейнер_для_списка)?.addView(картинка) } } }
override fun onPause() {
super.onPause()
вьюПервогоФрагмента } }
data class ВторойФрагмент(var такаяЖеФигня: String) : Fragment() {
fun получитьВ() = "В"
fun получитьИ() = "И"
override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
вьюВторогоФрагмента = inflater.inflate(R.layout.perviy_layout_ftoroga_fragment, container, false)
яКликЛушатель?.получитьБатон()?.setOnClickListener {
it.запуститьВращательнуюВДругуюСторону()
вьюВторогоФрагмента!!.findViewById<View>(R.id.текст_подсказка).сделатьНевидимым()
Glide.with(requireActivity())
.load(R.raw.gif)
.into(вьюВторогоФрагмента!!.findViewById(R.id.гиф_имаге));
вьюВторогоФрагмента!!.запуститьВращательнуюАнимацию()
Toast(activity).показатьТост(activity?.localClassName.orEmpty(), it.context) }
вьюВторогоФрагмента?.findViewById<TextView>(R.id.вью_текст)!!.text =
получитьВ() +
получитьЫ() +
получитьПробел() +
получитьВ() +
получитьЫ() +
получитьБ() +
получитьР() +
получитьА() +
получитьЛ() +
получитьИ() + получитьПробел() + получитьПробел() + получитьПробел() + такаяЖеФигня.сделатьБольшеБуквы()
return вьюВторогоФрагмента }
fun получитьБ() = "Б"
fun получитьР() = "Р"
fun получитьПробел() = " " }
fun String.сделатьБольшеБуквы() = this.uppercase()
fun получитьА() = "А"
fun получитьЛ() = "Л"
fun View.заанимироватьКрасиво() {
val shake: Animation = AnimationUtils.loadAnimation(this.context, R.anim.animation)
startAnimation(shake) }
fun View.стопАниматион() {
val shake: Animation = AnimationUtils.loadAnimation(this.context, R.anim.animation)
clearAnimation() }
fun View.сделатьНевидимым()  {
this.isVisible = false }
fun получитьЫ() = "Ы"