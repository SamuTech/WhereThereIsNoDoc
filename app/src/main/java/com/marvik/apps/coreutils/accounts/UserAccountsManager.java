package com.marvik.apps.coreutils.accounts;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;

import com.marvik.apps.wherethereisnodoc.R;


/**
 * Created by victor on 10/14/2015.
 */
public class UserAccountsManager {
    private Context context;

    public UserAccountsManager(Context context) {
        this.context = context;

    }

    public void addSyncedAccount(String accountType, String accountName, String authority) {
        if (!isAccountExists(getContext().getResources().getString(R.string.account_type))) {
            addAccount(accountType, accountName, authority);
        }
    }

    private void addAccount(String accountType, String accountName, String authority) {
        AccountManager accountManager = (AccountManager) getContext().getSystemService(Context.ACCOUNT_SERVICE);

        Account account = new Account(accountName, accountType);

        accountManager.addAccountExplicitly(account, accountType, null);

        forceSync(account, authority);
    }


    private boolean isAccountExists(String accountType) {
        AccountManager accountManager = (AccountManager) getContext().getSystemService(Context.ACCOUNT_SERVICE);
        Account[] accounts = accountManager.getAccounts();

        for (Account account : accounts) {
            if (account.type.equals(accountType)) {
                return true;
            }
        }
        return false;
    }

    public boolean isExistsUserAccount() {
        return isAccountExists(getContext().getResources().getString(R.string.account_type));
    }

    public void forceSync(Account account, String authority) {

        Bundle extras = new Bundle();
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true);//Force a manual sync
        extras.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true);//Make Sync Start Immediatley
        ContentResolver.requestSync(account, authority, extras);

    }

    public Context getContext() {
        return context;
    }

}
