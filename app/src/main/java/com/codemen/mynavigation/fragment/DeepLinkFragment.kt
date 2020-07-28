package com.codemen.mynavigation.fragment

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.codemen.mynavigation.R
import kotlinx.android.synthetic.main.fragment_deep_link.*


class DeepLinkFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_deep_link, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        text.text = arguments?.getString("myarg")

        send_notification_button.setOnClickListener {
            val editArgs = view.findViewById<EditText>(R.id.args_edit_text)
            val args = Bundle()
            args.putString("myarg", editArgs.text.toString())

            val deeplink = findNavController().createDeepLink()
                .setDestination(R.id.deeplink_dest)
                .setArguments(args)
                .createPendingIntent()

            val notificationManager =
                context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationManager.createNotificationChannel(
                    NotificationChannel(
                        "deeplink", "Deep Links", NotificationManager.IMPORTANCE_HIGH
                    )
                )
            }

            val builder = NotificationCompat.Builder(
                requireContext(), "deeplink"
            )
                .setContentTitle("Navigation")
                .setContentText("Deep link to Android")
                .setSmallIcon(R.drawable.ic_sentiment_satisfied)
                .setContentIntent(deeplink)
                .setAutoCancel(true)
            notificationManager.notify(0, builder.build())
        }
    }


}